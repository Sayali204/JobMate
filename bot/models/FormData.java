package bot.models;

import java.util.Map;

public class FormData {
    private String name;
    private String email;
    private String aboutYou;
    private String preferredRole;
    private String resumePath;
    private Map<String, CompanyInfo> companies;


    // Getters and Setters
    public String getResumePath() { return resumePath; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAboutYou() { return aboutYou; }
    public void setAboutYou(String aboutYou) { this.aboutYou = aboutYou; }

    public String getPreferredRole() { return preferredRole; }
    public void setPreferredRole(String preferredRole) { this.preferredRole = preferredRole; }

    public Map<String, CompanyInfo> getCompanies() { return companies; }
    public void setCompanies(Map<String, CompanyInfo> companies) { this.companies = companies; }

    public static class CompanyInfo {
        private String whyThisCompany;

        public String getWhyThisCompany() { return whyThisCompany; }
        public void setWhyThisCompany(String whyThisCompany) { this.whyThisCompany = whyThisCompany; }
    }
} 
