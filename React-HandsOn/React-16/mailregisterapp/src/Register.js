import { useState } from "react";

function Register() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event) => {

    event.preventDefault();

    if (name.length < 5) {
      alert("Name should have at least 5 characters.");
      return;
    }

    if (!(email.includes("@") && email.includes("."))) {
      alert("Enter a valid Email Address.");
      return;
    }

    if (password.length < 8) {
      alert("Password should have at least 8 characters.");
      return;
    }

    alert("Registration Successful");

  };

  return (

    <div>

      <h2>Mail Registration Form</h2>

      <form onSubmit={handleSubmit}>

        <label>Name :</label>
        <br />

        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <br /><br />

        <label>Email :</label>
        <br />

        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <br /><br />

        <label>Password :</label>
        <br />

        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <br /><br />

        <button type="submit">
          Register
        </button>

      </form>

    </div>

  );

}

export default Register;