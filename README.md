# PeerTubeMiner API Documentation

## General Information

* **OpenAPI Version:** `3.1.0`
* **API Version:** `v1`
* **Base URL:** `http://localhost:8081`

---

# Overview

The PeerTubeMiner API allows you to retrieve, adapt and store PeerTube channel data to VideoMiner API, including:

* Channel information
* Uploaded videos
* Video comments
* Video captions
* User information

---

# Channel Endpoints

Operations related to PeerTube channels.

---

## GET `/peertube/v1/{channelId}`

Retrieve a PeerTube channel.

### Description

Returns a `ChannelDTO` object containing channel information, videos, comments, captions, and uploader details.

### Parameters

| Name          | In    | Type      | Required | Default | Constraints | Description                                         |
| ------------- | ----- | --------- | -------- | ------- | ----------- | --------------------------------------------------- |
| `channelId`   | Path  | `string`  | ✅        | -       | -           | Name ID of the channel to be searched               |
| `maxVideos`   | Query | `integer` | ❌        | `10`    | `1 - 100`   | Maximum number of videos to be searched             |
| `maxComments` | Query | `integer` | ❌        | `2`     | `1 - 100`   | Maximum number of comments per video to be searched |

### Example Request

```http
GET /peertube/v1/transport_evolved_take_2@peertube.tv?maxVideos=10&maxComments=2
```

---

### Responses

#### ✅ 200 - Successful Response

Returns a `ChannelDTO` object.

##### Example Response

```json
{
  "id": "80",
  "name": "tv",
  "description": "canal de videos random",
  "createdTime": "2023-01-01T23:36:17.306Z",
  "videos": [
    {
      "id": "21856",
      "name": "Alien: Isolation live on iOS - 1/9/2023, 10:17:06 PM",
      "description": "HOW WILL YOU SURVIVE? Discover the true meaning of fear in Alien: Isolation, a survival horror set in an atmosphere of constant dread and mortal danger.",
      "releaseTime": "2023-01-09T22:32:41.126Z",
      "comments": [
        {
          "id": "3955",
          "text": "Funniest video I've ever seen",
          "createdOn": "2023-01-03T23:45:40.196Z"
        }
      ],
      "captions": [
        {
          "id": "1",
          "link": "/lazy-static/video-captions/68efe0a2-8ed8-4a6d-831a-ab8f5fc8f7fc-cy.vtt",
          "language": "Spanish"
        }
      ],
      "user": {
        "name": "stux",
        "user_link": "https://peertube.tv/accounts/stux",
        "picture_link": "https://peertube.tv/lazy-static/avatars/f8463b3f-2e2e-4f36-8bd3-fa9c0ef4f463.png"
      }
    }
  ]
}
```

---

#### ❌ 404 - Channel Not Found

```text
Channel not found
```

---

## POST `/peertube/v1/{channelId}`

Retrieve and store a PeerTube channel.

### Description

This operation retrieves a PeerTube channel and stores it in the VideoMiner database.

### Parameters

| Name          | In    | Type      | Required | Default | Constraints | Description                                         |
| ------------- | ----- | --------- | -------- | ------- | ----------- | --------------------------------------------------- |
| `channelId`   | Path  | `string`  | ✅        | -       | -           | Name of the channel to be created                   |
| `maxVideos`   | Query | `integer` | ❌        | `10`    | `1 - 100`   | Maximum number of videos to be included             |
| `maxComments` | Query | `integer` | ❌        | `2`     | `1 - 100`   | Maximum number of comments per video to be included |

### Example Request

```http
POST /peertube/v1/transport_evolved_take_2@peertube.tv?maxVideos=10&maxComments=2
```

---

### Responses

#### ✅ 201 - Channel Successfully Created

Returns a `ChannelDTO` object.

---

#### ❌ 404 - Channel Not Found

```text
Channel not found
```

---

#### ❌ 500 - Internal Server Error

```text
Internal server error
```

---

# Data Models

## ChannelDTO

Represents a PeerTube channel in the required format for VideoMiner.

| Field         | Type          | Description            |
| ------------- | ------------- | ---------------------- |
| `id`          | `string`      | Channel identifier     |
| `name`        | `string`      | Channel name           |
| `description` | `string`      | Channel description    |
| `createdTime` | `string`      | Channel creation date  |
| `videos`      | `VideosDTO[]` | List of channel videos |

---

## VideosDTO

| Field         | Type           | Description        |
| ------------- | -------------- | ------------------ |
| `id`          | `string`       | Video identifier   |
| `name`        | `string`       | Video title        |
| `description` | `string`       | Video description  |
| `releaseTime` | `string`       | Video release date |
| `user`        | `UserDTO`      | Video uploader     |
| `captions`    | `CaptionDTO[]` | Available captions |
| `comments`    | `CommentDTO[]` | Video comments     |

---

## UserDTO

| Field          | Type      | Description              |
| -------------- | --------- | ------------------------ |
| `id`           | `integer` | User identifier          |
| `name`         | `string`  | Username                 |
| `user_link`    | `string`  | Link to the user profile |
| `picture_link` | `string`  | Link to the user avatar  |

---

## CaptionDTO

| Field      | Type     | Description        |
| ---------- | -------- | ------------------ |
| `id`       | `string` | Caption identifier |
| `link`     | `string` | Caption file link  |
| `language` | `string` | Caption language   |

---

## CommentDTO

| Field       | Type     | Description           |
| ----------- | -------- | --------------------- |
| `id`        | `string` | Comment identifier    |
| `text`      | `string` | Comment content       |
| `createdOn` | `string` | Comment creation date |

---

# Error Codes

| Status Code | Description                    |
| ----------- | ------------------------------ |
| `200`       | Request completed successfully |
| `201`       | Resource created successfully  |
| `404`       | Channel not found              |
| `500`       | Internal server error          |

---

# Contact

Project repository:

* [PeerTubeMiner GitHub Repository](https://github.com/AlbertoCV03/PeerTubeMiner?utm_source=chatgpt.com)
