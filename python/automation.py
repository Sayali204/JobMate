### File: python/gpt_autofill.py

import json
import os
import openai

# === OpenAI ===
openai.api_key = os.getenv("REDACTED ")  # Place your API key 

# === INPUT CONFIG ===
resume_data = {
    "name": "Yash Dhake",
    "email": "dhakeyash123@gmail.com",
    "aboutYou": "",
    "preferredRole": "",
    "resumePath": "resume/Yash_Dhake_Resume.pdf",
    "naukriKeywords": ["Java", "Backend", "Fresher", "Remote"],
    "companies": ["Infosys", "TCS", "Wipro"]
}

# === GPT Prompts ===
def generate_about_you():
    prompt = (
        "Write a short About Me section for Yash Dhake, a B.E. IT student skilled in Java, Python, and Cloud, "
        "who has built open-source libraries and multithreaded backend systems."
    )
    return chatgpt(prompt)

def generate_preferred_role():
    return chatgpt("What internship role best fits someone with strong Java/Python skills, backend system design, and cloud experience?")

def generate_why_company(company):
    prompt = f"Why would Yash Dhake want to join {company}? Write a 2-line, tailored reason from a tech enthusiast's perspective."
    return chatgpt(prompt)

def generate_cover_letter(company, role):
    prompt = f"Write a short cover letter for a Java backend {role} at {company} for a student developer."
    return chatgpt(prompt)

# === Call OpenAI Chat ===
def chatgpt(prompt):
    print(f"Querying GPT for: {prompt[:60]}...")
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "user", "content": prompt}
        ]
    )
    return response["choices"][0]["message"]["content"].strip()

# === Main Logic ===
def autofill_fields(data):
    output = {
        "name": data["name"],
        "email": data["email"],
        "aboutYou": data["aboutYou"] or generate_about_you(),
        "preferredRole": data["preferredRole"] or generate_preferred_role(),
        "resumePath": data.get("resumePath", ""),
        "naukriKeywords": data.get("naukriKeywords", []),
        "companies": {}
    }

    for company in data["companies"]:
        output["companies"][company] = {
            "whyThisCompany": generate_why_company(company),
            "coverLetter": generate_cover_letter(company, output["preferredRole"])
        }

    with open("gpt_output.json", "w") as f:
        json.dump(output, f, indent=2)
    print("✅ Generated gpt_output.json")

# === Run ===
if __name__ == "__main__":
    autofill_fields(resume_data)
