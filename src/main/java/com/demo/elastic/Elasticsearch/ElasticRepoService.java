package com.demo.elastic.Elasticsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticRepoService {

    @Autowired
    ElasticRepo repo;

    public Iterable<LogData> findallservice() {
        return repo.findAll();
    }

    public List<LogData> findByHostnameservice(String hostname) {
        return repo.findByHostname(hostname);
    }

    public LogData setlogdata(LogData logData) {
        return repo.save(logData);
    }
}
