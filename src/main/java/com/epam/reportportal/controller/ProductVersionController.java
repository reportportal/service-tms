package com.epam.reportportal.controller;

import com.epam.reportportal.dto.ProductVersionRQ;
import com.epam.reportportal.dto.ProductVersionRS;
import com.epam.reportportal.service.ProductVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/{projectId}/tms/productversion")
public class ProductVersionController {

    private final ProductVersionService productVersionService;

    @Autowired
    public ProductVersionController(final ProductVersionService productVersionService) {
        this.productVersionService = productVersionService;
    }

    @GetMapping("/{productVersionId}")
    ProductVersionRS getById(@PathVariable("projectId") final long projectId,
                             @PathVariable("productVersionId") final long productVersionId) {
        return productVersionService.getById(projectId, productVersionId);
    }

    @PostMapping
    ProductVersionRS createVersion(@PathVariable("projectId") final long projectId,
                                   @RequestBody final ProductVersionRQ inputDto) {
        return productVersionService.create(projectId, inputDto);
    }

    @PutMapping("/{productVersionId}")
    ProductVersionRS updateVersion(@PathVariable("projectId") final long projectId,
                                   @PathVariable("productVersionId") final long productVersionId,
                                   @RequestBody final ProductVersionRQ inputDto) {
        return productVersionService.update(projectId, productVersionId,inputDto);
    }

    @DeleteMapping("/{productVersionId}")
    void deleteVersion(@PathVariable("projectId") final long projectId,
                       @PathVariable("productVersionId") final long productVersionId) {
        productVersionService.delete(projectId, productVersionId);
    }

}
