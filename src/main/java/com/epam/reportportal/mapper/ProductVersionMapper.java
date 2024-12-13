package com.epam.reportportal.mapper;

import com.epam.reportportal.db.model.ProductVersion;
import com.epam.reportportal.dto.ProductVersionRS;
import org.springframework.stereotype.Service;

@Service
public class ProductVersionMapper implements DtoMapper<ProductVersion, ProductVersionRS> {


    @Override
    public ProductVersionRS convert(ProductVersion productVersion) {
        return new ProductVersionRS(productVersion.getId(),
                productVersion.getVersion(),
                productVersion.getDocumentation(),
                productVersion.getTestPlans(),
                productVersion.getMilestones());

    }
}
