package com.example.reader;

    public class PipeOrderReader extends AbstractOrderReader {
        @Override
        public String getDelimiter() {
            return "\\|";
        }
    }



