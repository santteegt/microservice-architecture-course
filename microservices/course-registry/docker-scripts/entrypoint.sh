#!/bin/sh

TIMEOUT=20

if [ -z "$DB_HOST" ]; then
    echo "DB_HOST IS NOT SET. SETTING TO" $host
    DB_HOST=$host
fi

if [ -z "$DB_PORT" ]; then
    echo "DB_PORT IS NOT SET. SETTING TO" $port
    DB_PORT=$port
fi

HOST=$DB_HOST
PORT=$DB_PORT

echo 'HOTS ' $HOST
echo 'PORT ' $PORT

wait_for() {
  for i in `seq $TIMEOUT` ; do	
    echo 'Time '$i', Port '$PORT', host '$HOST
    nc -z "$HOST" "$PORT" > /dev/null 2>&1    
    result=$?
    echo 'Resultado '$result	
    if [ $result -eq 0 ] ; then
      echo 'Postgres is ready'
      echo $ACTUATOR_ARGS
      exec $@ $ACTUATOR_ARGS
      exit 0
    fi
    sleep 1
  done
  echo "Operation timed out" >&2
  exit 1
}

wait_for "$@"

