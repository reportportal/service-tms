package com.epam.reportportal.service;

import com.epam.reportportal.db.model.ProductVersion;
import com.epam.reportportal.dto.ProductVersionRQ;
import com.epam.reportportal.dto.ProductVersionRS;
import com.epam.reportportal.dto.TestCaseRQ;
import com.epam.reportportal.dto.TestCaseRS;

public interface ProductVersionService extends CrudService<ProductVersionRQ,ProductVersionRS,Long> {
}
