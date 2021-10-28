# URL Shortener

## Overview
This project is a study about clojure language. The mainly idea is make a simple url shortener by REST API.

## Usage
For usage you just need run:

```
lein run
```

## Database
It is used a SQLite database, that way not is necessary install server for store data.

## Requests structure
### Create a url
For create a short url, just execute:

```no-highlight
GET {{ ApiUrl }}/create?url={{ Url }}
```
