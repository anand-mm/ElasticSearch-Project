package com.demo.elastic.Elasticsearch;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

@Service
public class ElasticManualService {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    public List<LogData> getbyhostname(String index, String hostname) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("hostname", hostname));

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<LogData> productHits = elasticsearchOperations
                .search(searchQuery,
                        LogData.class,
                        IndexCoordinates.of(index));

        List<LogData> listMatches = new ArrayList<LogData>();
        productHits.forEach(searchHit -> {
            listMatches.add(searchHit.getContent());
        });
        return listMatches;
    }

    public List<LogData> getalldata(String index) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        Query searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<LogData> searchHits = elasticsearchOperations.search(searchQuery, LogData.class,
                IndexCoordinates.of(index));
        List<LogData> searchMatches = new ArrayList<LogData>();
        searchHits.forEach(searchHit -> {
            searchMatches.add(searchHit.getContent());
        });
        return searchMatches;
    }

}
