/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/5/5 14:13
 */
package com.liuballoon.service.impl;

import com.liuballoon.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ElasticsearchRestTemplate esRestTemplate;
}
