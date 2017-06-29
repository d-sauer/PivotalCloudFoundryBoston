#!/usr/bin/env bash

# Build route service
../../gradlew build

echo "Push service"
cf push --hostname rerouting-service