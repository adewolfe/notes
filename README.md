# Notes REST API

## Quickstart

### Pre-requisites

- Gradle 8+
- Java 17+

## Build

```shell
./gradlew build
```

## Run

```shell
./gradlew bootRun
```

## Examples

### Create a note

```shell
curl -X POST -H "Content-Type: application/json" -d '{"text": "My first note"}' "http://localhost:8080/api/notes?userId=1"
```

### Get all notes

```shell
curl "http://localhost:8080/api/notes"
```

### Get all notes for a user

```shell
curl "http://localhost:8080/api/notes?userId=1"
```


### Get a note

```shell
curl "http://localhost:8080/api/notes/1"
```

### Update a note

```shell
curl -X PUT -H "Content-Type: application/json" -d '{"text": "My updated note"}' "http://localhost:8080/api/notes/1"
```

### Delete a note

```shell
curl -X DELETE "http://localhost:8080/api/notes/1"
```

