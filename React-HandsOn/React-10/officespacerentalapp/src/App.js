import office1 from "./office1.jpg";
import office2 from "./office2.jpg";
import office3 from "./office3.jpg";

function App() {

  const heading = "Office Space";

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: office1
    },
    {
      Name: "TCS",
      Rent: 65000,
      Address: "Bangalore",
      Image: office2
    },
    {
      Name: "Infosys",
      Rent: 55000,
      Address: "Hyderabad",
      Image: office3
    }
  ];

  return (
    <div
      style={{
        width: "90%",
        margin: "30px auto",
        fontFamily: "Arial"
      }}
    >
      <h1 style={{ textAlign: "center" }}>
        {heading}, at Affordable Range
      </h1>

      {officeList.map((item, index) => (
        <div
          key={index}
          style={{
            width: "320px",
            display: "inline-block",
            margin: "20px",
            padding: "20px",
            border: "1px solid #ddd",
            borderRadius: "12px",
            boxShadow: "0 4px 10px rgba(0,0,0,0.2)",
            verticalAlign: "top",
            textAlign: "center"
          }}
        >
          <img
            src={item.Image}
            alt="Office Space"
            style={{
              width: "100%",
              height: "220px",
              objectFit: "cover",
              borderRadius: "10px"
            }}
          />

          <h2>{item.Name}</h2>

          <h3
            style={{
              color: item.Rent <= 60000 ? "red" : "green"
            }}
          >
            Rent : Rs. {item.Rent}
          </h3>

          <h3>{item.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;