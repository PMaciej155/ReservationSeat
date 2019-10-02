set -o xtrace

curl -H 'Content-Type: application/json' 'http://localhost:9090/api/screenings/all/' -w '\n'

curl -H 'Content-Type: application/json' 'http://localhost:9090/api/screenings?date=2019102&start=1600&end=2200' -w '\n'

curl -H 'Content-Type: application/json' 'http://localhost:9090/api/screenings/details?id=2' -w '\n'

curl -d '{ "7":"ADULT", "9":"STUDENT"}' -X POST -H 'Content-Type: application/json' 'http://localhost:9090/api/reservation?id=2&name=Oskar&surname=Malczynski-orgg' -w '\n'

curl -d '{ "4":"ADULT", "6":"STUDENT"}' -X POST -H 'Content-Type: application/json' 'http://localhost:9090/api/reservation?id=2&name=Oskar&surname=Malczynski' -w '\n'

curl -d '{ "5":"ADULT", "6":"STUDENT"}' -X POST -H 'Content-Type: application/json' 'http://localhost:9090/api/reservation?id=2&name=Oskar&surname=Malczynski' -w '\n'

curl -H 'Content-Type: application/json' 'http://localhost:9090/api/screenings/details?id=2' -w '\n'
