#!/bin/bash
docker-compose -f docker-compose-redis.yml up -d && mvn clean package -P dev && docker-compose -f docker-compose-dev.yml build && docker-compose -f docker-compose-dev.yml up -d