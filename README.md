# PeerTubeMiner API Documentation

## General Information

- **OpenAPI Version:** 3.1.0
- **API Version:** v0
- **Base URL:** `http://localhost:8081`

---

# Channel Endpoints

Operations related to channels.

## GET `/peertube/v1/{channelId}`

Retrieve a channel by its channel ID.

### Description

Returns a `ChannelDTO` object containing channel information, videos, comments, captions, and uploader details.

### Parameters

| Name | In | Type | Required | Default | Description |
|---|---|---|---|---|---|
| `channelId` | Path | `string` | ✅ | - | Name of channel to be searched |
| `maxVideos` | Query | `integer` | ❌ | `10` | Maximum number of videos to be searched |
| `maxComments` | Query | `integer` | ❌ | `2` | Maximum number of comments per video to be searched |

### Example Request

```http
GET /peertube/v1/transport_evolved_take_2@peertube.tv?maxVideos=10&maxComments=2

### Responses

#### ✅ 200 - Successful Response

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

#### ❌ 404 - Channel Not Found

```text
Channel not found
```

---

## POST `/peertube/v1/{channelId}`

Save a channel by its channel ID.

### Description

Creates and stores a `ChannelDTO` object in VideoMiner.

### Parameters

| Name | In | Type | Required | Default | Description |
|---|---|---|---|---|---|
| `channelId` | Path | `string` | ✅ | - | Name of channel to be created |
| `maxVideos` | Query | `integer` | ❌ | `10` | Maximum number of videos to be included |
| `maxComments` | Query | `integer` | ❌ | `2` | Maximum number of comments per video to be included |

### Example Request

```http
POST /peertube/v1/transport_evolved_take_2@peertube.tv?maxVideos=10&maxComments=2
```

### Responses

#### ✅ 201 - Channel Successfully Created

Returns a `ChannelDTO` object.

#### ❌ 500 - Invalid Channel Object

```text
The sent channel object was incorrectly formed.
Usually caused by a non existing channel name.
```

---

# Data Models

## ChannelDTO

| Field | Type |
|---|---|
| `id` | `string` |
| `name` | `string` |
| `description` | `string` |
| `createdTime` | `string` |
| `videos` | `VideosDTO[]` |

---

## VideosDTO

| Field | Type |
|---|---|
| `id` | `string` |
| `name` | `string` |
| `description` | `string` |
| `releaseTime` | `string` |
| `user` | `UserDTO` |
| `captions` | `CaptionDTO[]` |
| `comments` | `CommentDTO[]` |

---

## UserDTO

| Field | Type |
|---|---|
| `id` | `integer` |
| `name` | `string` |
| `user_link` | `string` |
| `picture_link` | `string` |

---

## CaptionDTO

| Field | Type |
|---|---|
| `id` | `string` |
| `link` | `string` |
| `language` | `string` |

---

## CommentDTO

| Field | Type |
|---|---|
| `id` | `string` |
| `text` | `string` |
| `createdOn` | `string` |