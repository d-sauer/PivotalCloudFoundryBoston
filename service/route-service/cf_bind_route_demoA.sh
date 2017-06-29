#!/usr/bin/env bash
echo "Bind route to Demo A"
cf bind-route-service local.pcfdev.io rerouting-service -n demo-a