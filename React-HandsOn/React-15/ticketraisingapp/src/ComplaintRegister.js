import { useState } from "react";

function ComplaintRegister() {

  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  return (

    <div>

      <h2>Register your complaints here!!!</h2>

      <form>

        <label>Employee Name :</label>

        <br />

        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
        />

        <br /><br />

        <label>Complaint :</label>

        <br />

        <textarea
          rows="5"
          cols="35"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
        ></textarea>

        <br /><br />

        <button type="submit">
          Submit
        </button>

      </form>

    </div>

  );

}

export default ComplaintRegister;