# 📱 Android App Documentation: MyExpandableListView

________________________________________
## 🧾 General Information
**Project Name:**
MyExpandableListView
**Author(s):**
Zeev Fraiman
**Date:**
May 2024
**Language:**
Java
**Development Environment:**
Android Studio
**Android Version (minSdk / targetSdk):**
26 / 33
________________________________________
## 🎯 Project Goal
•	**What problem does the app solve:** It demonstrates the use of the `ExpandableListView` component to display hierarchical data (groups and child items).
•	**Why is this task important:** Hierarchical lists are frequently used in mobile apps to structure information (product categories, settings, lists of countries and cities).
•	**Target Audience:** Developers learning the basics of Android UI components.
________________________________________
## 📌 Application Requirements
### Functional Requirements
•	Display a list of countries.
•	Expand the list of cities when a country is clicked.
•	Show Toast notifications when a group or item is clicked.
### Non-functional Requirements
•	**Performance:** Instant response to taps.
•	**Usability:** Intuitive interface based on standard list patterns.
•	**Reliability:** Handling null states during initialization.
________________________________________
## 🧠 General Architecture
•	**Approach:**
–	MVC (Model-View-Controller)
•	**Why this approach:** For a small demo project, MVC is the simplest and most effective way to separate data from the presentation layer.
•	**Core Components:**
– `MainActivity`: Acts as both Controller and View.
– `CountryCityListAdapter`: Adapter binding data to the UI.
– `ArrayList/HashMap`: Data model.
________________________________________
## 🧩 UML Diagram
`[MainActivity]` –> `[CountryCityListAdapter]` –> `[BaseExpandableListAdapter]`
`[MainActivity]` uses `[HashMap<String, ArrayList<String>>]` as the data source.
________________________________________
## 🧩 Detailed Class Description
### 📌 Class: MainActivity
**Role:** Main screen of the application.
**Responsibility:** Data initialization, `ExpandableListView` setup, and click event handling.
**Main Methods:** 
- `onCreate()` — sets layout and starts initialization.
- `initData()` — populates lists of countries and cities.
- `initElements()` — finds views and sets the adapter.
**Interaction:** Creates an instance of `CountryCityListAdapter` and passes the data to it.

### 📌 Class: CountryCityListAdapter
**Role:** Adapter for `ExpandableListView`.
**Responsibility:** Creating views for groups (countries) and children (cities), managing data access.
**Why it's used:** Inherits from `BaseExpandableListAdapter` for custom item rendering.
________________________________________
## 🔄 App Workflow
1. App launches.
2. `MainActivity` initializes the `HashMap` with data.
3. `ExpandableListView` requests data from the adapter.
4. User clicks a country -> the list of cities expands.
5. User clicks a city -> a `Toast` with the city name appears.
________________________________________
## 🎨 UI/UX Analysis
•	**Interface Logic:** Standard system look for maximum familiarity.
•	**Principles Used:**
–	Simplicity
–	Logical flow
–	Accessibility (Large fonts: 25dp for groups, 20dp for items).
•	**Potential Improvements:** Add country flag icons and custom expansion arrows.
________________________________________
## ⚙️ Threading
•	**Threads Used:** All operations run on the Main (UI) thread.
•	**Why:** Small data size ensures no UI blocking.
•	**Prevention:**
–	ANR: Data is static and loaded instantly.
–	Memory Leaks: No long-running background tasks.
________________________________________
## 💾 Data Management
•	**Storage:** In-memory (`ArrayList`, `HashMap`).
•	**Why:** Persistent storage is not required for this demonstration.
________________________________________
## 🔐 Security (Basic Level)
•	No sensitive user data is handled in this application.
________________________________________
## 🧪 Testing
•	**Testing:** Manual testing performed on an emulator.
•	**Scope:** Verification of list expansion and correct city name display.
________________________________________
## 🐞 Error Handling
•	`null` check for `ExpandableListView` in the `initElements()` method.
________________________________________
## ⚡ Performance
•	Implementation of the `convertView` pattern in the adapter for view recycling.
________________________________________
## 🚀 Scalability
•	Loading data from JSON or an API.
•	Adding a search feature for cities.
•	Migrating to Room database.
________________________________________
## 📊 Project Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 7 |
| Reliability | 9 |
| Overall Level | 8 |
________________________________________
## 🏁 Conclusion
•	**Highlights:** Clear separation of data and logic within the adapter.
•	**Challenges:** Adjusting custom font sizes within standard layouts.
•	**Skills Acquired:** Working with `BaseExpandableListAdapter` and handling hierarchical list events.
