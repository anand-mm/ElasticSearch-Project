package com.demo.elastic.Elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "metricbeat-devops-#{T(java.time.LocalDate).now().toString()}")
public class LogData {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "war_name")
    private String warname;

    @Field(type = FieldType.Text, name = "hostname")
    private String hostname;

    @Field(type = FieldType.Text, name = "timestamp")
    private String time;

}
