package com.autopagination.page.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

    @AllArgsConstructor
    @Getter
    public class RestResponse<T> {
        @JsonProperty("data")
        private List<T> subjectList;
    }

