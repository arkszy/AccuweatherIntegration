#!/bin/bash
mvn clean package -P dev && docker-compose -f docker-compose-dev.yml build && docker-compose -f docker-compose-dev.yml up -d