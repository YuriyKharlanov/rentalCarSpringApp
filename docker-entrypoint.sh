#!/bin/sh

set -e

#start JAVA Then exec the container's main process (what's set as CMD in the Dockerfile).
exec "$@"
