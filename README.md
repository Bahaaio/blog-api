# 📝 Blog API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Docker](https://img.shields.io/badge/Docker-ready-blue)

A RESTful API for a personal blogging platform built with Spring Boot.

## Features

- Create, read, update, and delete blog posts
- Search posts by title, content, or category

## Quick Start

```bash
git clone https://github.com/Bahaaio/blog-api
cd blog-api
docker-compose up -d
./mvnw spring-boot:run
```

API available at `http://localhost:8080`

## API Endpoints

### Create Blog Post

```http
POST /posts
```

Returns `201 Created`

<details>
<summary>Request</summary>

```json
{
  "title": "10 Reasons Why Coffee Makes You a Better Developer ☕",
  "content": "Let's face it, code and coffee go together like semicolons and syntax errors. Here's why your next cup might be the key to your next breakthrough...",
  "category": "Developer Life",
  "tags": ["coffee", "productivity", "coding", "life-hacks"]
}
```

</details>

<details>
<summary>Response</summary>

```json
{
  "id": 1,
  "title": "10 Reasons Why Coffee Makes You a Better Developer ☕",
  "content": "Let's face it, code and coffee go together like semicolons and syntax errors. Here's why your next cup might be the key to your next breakthrough...",
  "category": "Developer Life",
  "tags": ["coffee", "productivity", "coding", "life-hacks"],
  "createdAt": "2024-01-01T12:00:00",
  "updatedAt": "2024-01-01T12:00:00"
}
```

</details>

### Get All Posts

```http
GET /posts
```

Returns `200 OK`

<details>
<summary>Response</summary>

```json
[
  {
    "id": 1,
    "title": "10 Reasons Why Coffee Makes You a Better Developer ☕",
    "content": "Let's face it, code and coffee go together like semicolons and syntax errors. Here's why your next cup might be the key to your next breakthrough...",
    "category": "Developer Life",
    "tags": ["coffee", "productivity", "coding", "life-hacks"],
    "createdAt": "2024-01-01T12:00:00",
    "updatedAt": "2024-01-01T12:00:00"
  },
  {
    "id": 2,
    "title": "Building APIs That Don't Suck: A Developer's Guide 🚀",
    "content": "Your users deserve better than 500 errors and cryptic responses. Here's how to build APIs that developers actually love to use...",
    "category": "Web Development",
    "tags": ["api", "backend", "best-practices", "spring-boot"],
    "createdAt": "2024-01-02T09:30:00",
    "updatedAt": "2024-01-02T09:30:00"
  }
]
```

</details>

### Search Posts

```http
GET /posts?term=coffee
```

Returns `200 OK`

```json
[
  {
    "id": 1,
    "title": "10 Reasons Why Coffee Makes You a Better Developer ☕",
    "content": "Let's face it, code and coffee go together like semicolons and syntax errors. Here's why your next cup might be the key to your next breakthrough...",
    "category": "Developer Life",
    "tags": ["coffee", "productivity", "coding", "life-hacks"],
    "createdAt": "2024-01-01T12:00:00",
    "updatedAt": "2024-01-01T12:00:00"
  }
]
```

Searches title, content, and category fields

### Get Single Post

```http
GET /posts/{id}
```

Returns `200 OK` or `404 Not Found`

<details>
<summary>Response</summary>

```json
{
  "id": 1,
  "title": "10 Reasons Why Coffee Makes You a Better Developer ☕",
  "content": "Let's face it, code and coffee go together like semicolons and syntax errors. Here's why your next cup might be the key to your next breakthrough...",
  "category": "Developer Life",
  "tags": ["coffee", "productivity", "coding", "life-hacks"],
  "createdAt": "2024-01-01T12:00:00",
  "updatedAt": "2024-01-01T12:00:00"
}
```

</details>

### Update Post

```http
PUT /posts/{id}
```

Returns `200 OK` or `404 Not Found`

<details>
<summary>Request</summary>

```json
{
  "title": "Why Debugging at 3 AM Always Finds the Bug 🐛",
  "content": "There's something magical about late-night debugging sessions. Maybe it's the quiet, maybe it's the desperation, but somehow that elusive bug always reveals itself...",
  "category": "Developer Life",
  "tags": ["debugging", "midnight-coding", "developer-humor"]
}
```

</details>

<details>
<summary>Response</summary>

```json
{
  "id": 1,
  "title": "Why Debugging at 3 AM Always Finds the Bug 🐛",
  "content": "There's something magical about late-night debugging sessions. Maybe it's the quiet, maybe it's the desperation, but somehow that elusive bug always reveals itself...",
  "category": "Developer Life",
  "tags": ["debugging", "midnight-coding", "developer-humor"],
  "createdAt": "2024-01-01T12:00:00",
  "updatedAt": "2024-01-01T12:30:00"
}
```

</details>

### Delete Post

```http
DELETE /posts/{id}
```

Returns `204 No Content` or `404 Not Found`

## Validation

The API includes input validation for all POST/PUT requests:

| Field    | Constraints              |
| -------- | ------------------------ |
| title    | 4-200 characters, unique |
| content  | Max 10,000 characters    |
| category | Max 50 characters        |
| tags     | Max 10 tags, non-null    |

### Validation Error Response

Returns `400 Bad Request` with field-specific error messages:

```json
[
  { "title": "size must be between 4 and 200" },
  { "content": "must not be blank" }
]
```

---

> Inspired by [roadmap.sh Blogging Platform API](https://roadmap.sh/projects/blogging-platform-api)
