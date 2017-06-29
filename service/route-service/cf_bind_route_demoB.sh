#!/usr/bin/env bash
echo "Bind route to Demo B"
cf bind-route-service local.pcfdev.io rerouting-service -n demo-b