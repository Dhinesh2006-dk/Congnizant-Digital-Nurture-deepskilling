import "./App.css";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (

    <div className="container">

      {showCourses && <CourseDetails />}

      {showBooks ? <BookDetails /> : null}

      {showBlogs ? <BlogDetails /> : null}

    </div>

  );

}

export default App;