public class Student {
    private int studentID;
    private String firstName, lastName, middleName, gender, course, address;
    private int age, yearLevel, contactNumber;

    private Student(Builder builder) {
        this.studentID = builder.studentID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.gender = builder.gender;
        this.age = builder.age;
        this.course = builder.course;
        this.yearLevel = builder.yearLevel;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }

   
    private String padRight(String text, int length) {
        String result = (text == null) ? "" : text;
        while (result.length() < length) {
            result += " ";
        }
        return result;
    }

    public String displayInfo() {
        
        return padRight("ID: " + studentID, 7) + " | " +
               padRight(firstName + " " + lastName, 25) + " | " +
               padRight(gender, 7) + " | " +
               padRight("Age: " + age, 8) + " | " +
               padRight("Yr: " + yearLevel, 6) + " | " +
               padRight(course, 6) + " | " +
               padRight(address, 15) + " | " +
               "Contact: " + contactNumber;
    }

    
    public int getStudentID() { return studentID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int getYearLevel() { return yearLevel; }
    public String getAddress() { return address; }
    public int getContactNumber() { return contactNumber; }

    public static class Builder {
        private int studentID, age, yearLevel, contactNumber;
        private String firstName, lastName, middleName, gender, course, address;

        public Builder setStudentID(int id) { this.studentID = id; return this; }
        public Builder setFirstName(String f) { this.firstName = f; return this; }
        public Builder setLastName(String l) { this.lastName = l; return this; }
        public Builder setMiddleName(String m) { this.middleName = m; return this; }
        public Builder setGender(String g) { this.gender = g; return this; }
        public Builder setAge(int a) { this.age = a; return this; }
        public Builder setCourse(String c) { this.course = c; return this; }
        public Builder setYearLevel(int y) { this.yearLevel = y; return this; }
        public Builder setAddress(String add) { this.address = add; return this; }
        public Builder setContactNumber(int n) { this.contactNumber = n; return this; }
        public Student build() { return new Student(this); }
    }
}
