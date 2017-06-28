#!/usr/bin/env bash

../../gradlew build

echo "Push application demoA"
cf push --hostname demo-a