package com.skill.test.zalando.hiring.sprint;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    ProductLineTestReport test(Stream<Product> products) {
        if (products == null) {
            return new ProductLineTestReport(0, 0, 0, 0);
        }

        List<Product> correctProducts = products.filter(Objects::nonNull)
                .filter(p -> !"invalid".equalsIgnoreCase(p.getStatus()))
                .skip(10)
                .limit(20)
                .collect(Collectors.toList());
        if (correctProducts.size() == 0) {
            return new ProductLineTestReport(0, 0, 0, 0);
        }

        long correctCnt = 0L;
        long checkedExcCnt = 0L;
        long uncheckedExcCnt = 0L;
        long otherExcCnt = 0L;

        for (Product p : correctProducts) {
            try {
                verifier.verify(p);
                //throw new Throwable();
            } catch (RuntimeException rte) {
                uncheckedExcCnt++;
            } catch (Exception e) {
                checkedExcCnt++;
            } catch (Throwable t) {
                otherExcCnt++;
            }
        }

        return new ProductLineTestReport(correctProducts.size() - (checkedExcCnt + uncheckedExcCnt + otherExcCnt), checkedExcCnt, uncheckedExcCnt, otherExcCnt);
    }

}
