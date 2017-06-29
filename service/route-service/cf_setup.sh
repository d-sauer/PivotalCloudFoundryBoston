#!/usr/bin/env bash

# Build route service
../../gradlew build

./cf_push.sh

echo "Create a user provided service that contains the route service configuration information"
cf create-user-provided-service rerouting-service -r https://rerouting-service.local.pcfdev.io