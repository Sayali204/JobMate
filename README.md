
=======
# JobMate
# 💼 JobAutoPilot
>>>>>>> 62a846bd240e7a3f90915e8bcf9ae6d92fd67a7a

**AI-powered Resume Autofill and Job Application Bot built with GPT-4, Python, Java, and Selenium.**

---

##  Overview

**JobAutoPilot** is a smart, time-saving automation suite that:
-  Uses GPT-4 to auto-generate personalized application data (e.g. “About You”, “Why This Company”)
-  Parses your resume to understand your skills and map job preferences
-  Fills job application forms on platforms like **Naukri.com** using **Selenium automation**
-  Bridges Python and Java using a shared JSON interface for seamless multi-language orchestration

>  Result: Saves 80–90% of the time typically spent on filling repetitive job forms while improving quality and personalization.

 
---

##  Features
=======
---

##  Architecture
[Resume Input]
      │
      ▼
python/automation.py
- Calls OpenAI API
- Generates gpt_output.json (structured autofill data)

      │
      ▼
java/GPTFieldFiller.java
- Parses gpt_output.json
- Populates FormData model

      │
      ▼
java/Bot.java
- Uses Selenium to autofill job application forms



---

## ⚙️ Features

| Feature                        | Description                                                                 |
|-------------------------------|-----------------------------------------------------------------------------|
|  GPT-Powered Autofill        | Auto-generates “About You”, "Why This Company", and role preference         |
|  Resume Understanding        | Parses resume to tailor application content intelligently                   |
|  Naukri.com Automation       | Uses Selenium to log in and apply to jobs on Naukri automatically           |
|  Multi-Language Pipeline     | Python handles AI, Java handles browser automation                          |
|  Personalized Applications   | GPT fields vary by company — no copy-paste                                 |
|  Time-Efficient               | Apply to a job in < 10 seconds per listing                                 |

---

##  Tech Stack

- **Python 3.11+**
  - OpenAI GPT-4
  - `json`, `os`, `dotenv`
- **Java 17+**
  - Selenium WebDriver
  - Jackson (for JSON)
- **ChromeDriver + Chrome 137**

---

##  How It Works (End-to-End)

1. **Run Python script**: `automation.py`
   - Parses your resume
   - Generates `gpt_output.json` with custom application data

2. **Run Java bot**: `Bot.java`
   - Logs into Naukri
   - Loads `gpt_output.json`
   - Clicks Apply on job links
   - Fills required fields
   - Submits your job application

---


