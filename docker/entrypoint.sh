#!/usr/bin/env bash

set -e

if [ -z "$@" ]; then
        java ${JAVA_OPTS} -jar *.jar ${ARGS}
else
        exec "$@"
fi