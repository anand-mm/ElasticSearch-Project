package com.demo.elastic.Elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticRepo extends ElasticsearchRepository<LogData, String> {

    List<LogData> findByHostname(String hostname);

}
