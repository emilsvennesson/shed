# Meeting Agenda 

- **Group**:        shed
- **Date**: 21-10-04
- **Chair**:        Samuel Kajava
- **Participants**: Samuel Kajava, Daniel Ericsson, Daniel Rygaard, Pouya Shirin & Emil Svensson

## Objectives

* Assignment for thursday
* Model

## Reports

* Samuel:
  * Products needs some controller logic, otherwise done
  * APK leaderboard needs to be done
  * SDD - not started
* Daniel E.
  * RAD is done
* Daniel R.
  * Low fidelity sketch done for drink generator
  * UML for drink generator needs to be done
* Emil:
  * Model - we need to get feedback from frontend in order to know what to implement. The solution for this is to sit together
  * We need getCategory from backend in the frontend, otherwise Products page won't be finished
* Pouya:
  * Concatenate string for getByMethod is done

## Discussion items

* Assignment deadline oct 7 17.00 (thursday):
  * Work hard on the project until wednesday
  * On thursday: finalize what we have so far
* Book work sessions for this week

## Outcomes and assignments

### Outcomes

* Main view:

  * List new products on start page instead of just the 20 first products

  * Modal pane for every page that use products

* Products:

  * Filter component
  * Header component (breadcrumbs and active category)
  * Sidebar should display active category
  * Pagination

* APK Leaderboard:

  * De-prioritize this page, we'll implement it if there's time

* Drink generator:

  * Let's not prioritze this feature this week

* Favorites:

  * This is basically a copy pasta from the start page and can be done in a few hours.

* On thursday: finalize what we have so far

  * Make code readable
  * Look over RAD and SDD
  * We have something runnable in decent condition

### Assignments

* Everyone today:
  * Merge all branches with main
* Everyone Thursday: finalize everything

* Samuel:
  * New products:
    - Backend: getNewProducts(int amount)
    - Frontend: call the backend function above
  * Modal pane

- Emil:
  - Implement active category in backend
  - Control active category in frontend
- Daniel E.:
  - Caching images
- Daniel R.:
  - SDD
  - Favorites: implement with Product class instead of only product ID
- Pouya:
  - Search function
  - SDD
- Dates for this week:
  - Monday: 15
  - Tuesday: 10-12
  - Wednesday: 10-12, 15 - ..
  - Thursday: 
    - meeting 8.00
    - 13.00 and forwards



## Wrap up

* Next meeting: 21-10-07,  8.00-10.00, F4054
