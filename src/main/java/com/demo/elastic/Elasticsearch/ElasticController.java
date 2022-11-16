package com.demo.elastic.Elasticsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ElasticController {

    ElasticManualService elasticManualService;
    ElasticRepoService elasticRepoService;

    @Autowired
    public ElasticController(ElasticManualService elasticManualService, ElasticRepoService elasticRepoService) {
        this.elasticManualService = elasticManualService;
        this.elasticRepoService = elasticRepoService;
    }

    @GetMapping("/getbyhostname")
    public List<LogData> getbyhostname(@RequestParam("index") String indexname,
            @RequestParam("hostname") String hostname) {
        return elasticManualService.getbyhostname(indexname, hostname);
    }

    // @GetMapping("/getdata")
    // public Iterable<LogData> getalldata() {
    // return elasticRepoService.findallservice();
    // }

    // @GetMapping("/getbyhostname")
    // public List<LogData> getfromhostname(@RequestParam("hostname") String
    // hostname) {
    // return elasticRepoService.findByHostnameservice(hostname);
    // }

    @PostMapping("/setdata")
    public LogData setlogdata(@RequestBody LogData logData) {
        return elasticRepoService.setlogdata(logData);
    }

    @GetMapping("/getalldata")
    public List<LogData> getdata(@RequestParam("index") String indexname) {

        return elasticManualService.getalldata(indexname);
    }

}
