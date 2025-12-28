# AI-Powered Chatbot

A full-stack AI chatbot application with **Angular 17** frontend and **Spring Boot (Java)** backend.  
It uses the **OpenRouter GPT API** to generate AI responses in real-time.

---

## Features

- Real-time AI chat  
- Separate backend and frontend  
- Easy integration with OpenRouter GPT API  

---

## Tech Stack

- Frontend: Angular 17, TypeScript  
- Backend: Spring Boot, Java  
- AI API: OpenRouter GPT  

## CI/CD Pipeline & Docker Workflow

This project uses **Docker** and **GitHub Actions** to automate building and deploying the AI Chatbot.

### Workflow Overview

1. **Push Code to GitHub**  
   - Backend: `chatbot-backend/`  
   - Frontend: `chatbot-frontend/`  

2. **GitHub Actions Pipeline**  
   - Automatically triggered on every push to `main`  
   - Steps:
     - Checkout code
     - Build backend Docker image
     - Build frontend Docker image
     - Push images to Docker Hub

3. **Docker Hub**  
   - Backend Image: `chamesh/ai-chatbot-backend:latest`  
   - Frontend Image: `chamesh/ai-chatbot-frontend:latest`  

4. **Deployment**  
   - Docker images can be deployed anywhere:
     - Cloud Server
     - VPS / VM
     - Local Machine (requires Docker installed)

### Notes

- Backend uses **Java Spring Boot**, exposed on port `8080`.  
- Frontend uses **Angular**, served via Nginx on port `80`.  
- Dockerfiles are located in their respective folders:
  - `chatbot-backend/Dockerfile`
  - `chatbot-frontend/Dockerfile`  
- GitHub Actions workflow: `.github/workflows/docker.yml`  
- Images are automatically rebuilt and pushed on every commit to `main`.  




