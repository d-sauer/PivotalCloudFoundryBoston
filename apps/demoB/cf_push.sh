#!/usr/bin/env bash

../../gradlew build

echo "Push application demoB"
cf push --hostname demo-b