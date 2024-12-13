package com.epam.reportportal.service;

import com.epam.reportportal.db.model.*;
import com.epam.reportportal.db.repository.ProductVersionRepository;
import com.epam.reportportal.db.repository.TestCaseRepository;
import com.epam.reportportal.db.repository.TestSuiteRepository;
import com.epam.reportportal.dto.ProductVersionRQ;
import com.epam.reportportal.dto.ProductVersionRS;
import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;
import com.epam.reportportal.exception.NotFoundException;
import com.epam.reportportal.mapper.DtoMapper;
import com.epam.reportportal.mapper.ProductVersionMapper;
import com.epam.reportportal.mapper.TestCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

import static com.epam.reportportal.service.TestSuiteServiceImpl.TEST_SUITE_NOT_FOUND_BY_ID;

@Service
public class ProductVersionServiceImpl implements ProductVersionService {

    private static final String VERSION_NOT_FOUND_BY_ID = "Product Version cannot be found by id: {0}";

    private final DtoMapper<ProductVersion, ProductVersionRS> productVersionMapper;
    private final ProductVersionRepository productVersionRepository;

    @Autowired
    public ProductVersionServiceImpl(final ProductVersionMapper productVersionMapper,
                                     final ProductVersionRepository productVersionRepository) {
        this.productVersionMapper = productVersionMapper;
        this.productVersionRepository = productVersionRepository;
    }

    @Override
    public ProductVersionRS create(long projectID, final ProductVersionRQ inputDto) {
//        final var testSuite = testSuiteRepository.findById(inputDto.testSuiteId())
//                .orElseThrow(NotFoundException.supplier(TEST_SUITE_NOT_FOUND_BY_ID, inputDto.testSuiteId())); // replace by getting default Test Suite
        final var productVersion = new ProductVersion(null,
                inputDto.version(),
                inputDto.documentation(),
                inputDto.testPlans().stream().map(it -> {
                  var tp = new TestPlan();
                  tp.setId(it);
                  return tp;
                }).collect(Collectors.toSet()),
                inputDto.milestones().stream().map(it -> {
                    var milestone = new Milestone();
                    milestone.setId(it);
                    return milestone;
                }).collect(Collectors.toSet()));

        return productVersionMapper.convert(productVersionRepository.save(productVersion));
    }

    @Override
    public ProductVersionRS update(long projectID,final Long productVersionID, final ProductVersionRQ inputDto) {
        final var productVersion = new ProductVersion(productVersionID,
                inputDto.version(),
                inputDto.documentation(),
                inputDto.testPlans().stream().map(it -> {
                    var tp = new TestPlan();
                    tp.setId(it);
                    return tp;
                }).collect(Collectors.toSet()),
                inputDto.milestones().stream().map(it -> {
                    var milestone = new Milestone();
                    milestone.setId(it);
                    return milestone;
                }).collect(Collectors.toSet()));

        return productVersionMapper.convert(productVersionRepository.save(productVersion));    }

    @Override
    public void delete(long projectID,Long id) {
        productVersionRepository.deleteById(id);
    }

    @Override
    public ProductVersionRS getById(long projectID, Long id) {
        return productVersionMapper.convert(productVersionRepository.findById(id)
                .orElseThrow(NotFoundException.supplier(VERSION_NOT_FOUND_BY_ID, id)));
    }


}
