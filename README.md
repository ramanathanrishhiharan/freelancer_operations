# FreelanceOS

**An open-source business operating system for creative freelancers and small agencies.**

FreelanceOS brings client management, project tracking, and business operations into one workspace. No more juggling Notion, Trello, Excel, Toggl, and three other tools just to run your freelance business.

The current MVP delivers a secure, scalable CRM foundation. Future releases will expand into a full operating system built specifically for designers, developers, and creative agencies.

---

## The Problem

Most freelancers manage their business across too many disconnected tools:

- Client info lives in emails, spreadsheets, and random docs
- Leads fall through the cracks without proper follow-up
- Projects get harder to track as the workload grows
- Invoices are created manually, eating into billable time
- Income, expenses, and profitability are difficult to measure
- Enterprise CRM tools are overkill and overpriced for solo operators

FreelanceOS solves this with a single, lightweight platform that grows with your business.

---

## Current MVP

### Authentication
- User registration and login
- JWT-based stateless authentication
- BCrypt password encryption
- Spring Security integration

### Contact Management
- Create and manage contacts
- Track leads and their status
- Convert leads into clients
- User-scoped ownership of contacts

### Project Management
- Create and update projects
- Assign projects to clients
- Track project status
- Delete projects

### Backend Architecture
- RESTful API with layered architecture
- DTO pattern and service layer
- Repository pattern with exception handling
- PostgreSQL database

---

## Tech Stack

**Backend**
- Java 21
- Spring Boot, Spring Security, Spring Data JPA
- Hibernate
- JWT authentication
- PostgreSQL
- Maven

**Frontend**
- Next.js
- React with TypeScript
- Tailwind CSS

---

## Architecture

The backend follows a clean layered architecture:

```
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Supporting layers: DTOs, Entity Models, Security, Exception Handling, Configuration.

This separation keeps the codebase maintainable, testable, and easy to extend.

---

## Roadmap

### Phase 1 — Foundation (Current)
Authentication, contact management, lead management, client management, project management

### Phase 2 — Productivity
Dashboard, task management, calendar, notes, time tracking

### Phase 3 — Business Operations
Invoice generation, payments, analytics, reports, file storage

### Phase 4 — Growth
AI assistant, email integration, client portal, team collaboration, advanced analytics

---

## Future Features

**Business Management**
Invoice generation, payment tracking, income analytics, expense tracking, financial reports

**Productivity**
Task management, time tracking, calendar, notes, daily planner, activity timeline, reminders

**Creative Workflow**
Mood boards, asset library, brand management, client feedback, revision tracking, design approvals

**Collaboration**
Team workspaces, roles and permissions, shared projects, client portals, internal comments

**Communication**
Email integration, meeting scheduling, client communication history, automated follow-ups

**AI**
Proposal generation, invoice generation, meeting summaries, smart reminders, business insights

**Analytics**
Revenue dashboard, project analytics, client insights, productivity reports, time analysis

---

## Who It's For

FreelanceOS is built for:

- UI/UX and graphic designers
- Brand and product designers
- Web and freelance developers
- Digital and creative agencies
- Independent consultants and small creative teams

---

## Contributing

Contributions are welcome. Whether you want to fix a bug, improve the docs, add a feature, or suggest a new idea, open an issue or submit a pull request.

---

## Vision

FreelanceOS is not another generic CRM.

The goal is a complete business operating system for creative professionals: one place to manage clients, projects, finances, collaboration, and creative workflows. Less time managing the business. More time doing the work.
