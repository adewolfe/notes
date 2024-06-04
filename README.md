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
curl -X POST -H "X-User-Id: 1" -H "Content-Type: application/json" -d '{"text": "My first note"}' "http://localhost:8080/api/notes"
```

### Get all notes (for a user)

```shell
curl -H "X-User-Id: 1" "http://localhost:8080/api/notes"
```

### Get all notes (for a different user)

```shell
curl -H "X-User-Id: 2" "http://localhost:8080/api/notes"
```


### Get a note (for the user that owns the note)

```shell
curl -H "X-User-Id: 1" "http://localhost:8080/api/notes/1"
```

### Get a note (for a user that does not own the note)

```shell
curl -H "X-User-Id: 2" "http://localhost:8080/api/notes/1"
```

### Update a note (for the user that owns the note)

```shell
curl -X PUT -H "X-User-Id: 1" -H "Content-Type: application/json" -d '{"text": "My updated note"}' "http://localhost:8080/api/notes/1"
```

### Update a note (for a user that does not own the note)

```shell
curl -X PUT -H "X-User-Id: 1" -H "Content-Type: application/json" -d '{"text": "My updated note"}' "http://localhost:8080/api/notes/1"
```

### Delete a note (for a user that does not own the note)

```shell
curl -X DELETE -H "X-User-Id: 1" "http://localhost:8080/api/notes/1"
```

### Delete a note (for the user that owns the note)

```shell
curl -X DELETE -H "X-User-Id: 1" "http://localhost:8080/api/notes/1"
```
