import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [novellid, setNovellid] = useState([]);
  const pealkiriRef = useRef();
  const sisuRef = useRef();
  const aastaRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/novellid")
      .then(response => response.json())
      .then(body => {
        setNovellid(body);
      })
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/novellid/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setNovellid(json);
      })
  }

  function lisa() {
    if (pealkiriRef.current.value.trim() === "") {
      return;
    }
    const novell = {
      "pealkiri": pealkiriRef.current.value,
      "sisu": sisuRef.current.value,
      "aasta": aastaRef.current.value
    }
    fetch("http://localhost:8080/novellid", 
    {
      "method": "POST", 
      "body": JSON.stringify(novell), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setNovellid(json);
      })
  }


  return (
    <div className="App">
      <div>
        
        <label>Raamatu pealkiri</label> <br/>
        <input ref={pealkiriRef} type="text" /> <br />
        <label>Sisu</label> <br/>
        <input ref={sisuRef} type="text" /> <br />
        <label>Aasta</label> <br/>
        <input ref={aastaRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br />

        {novellid.map(n => 
          <div>{n.id}  |  {n.pealkiri}  |  {n.sisu}  |  {n.aasta}  
            <button onClick={() => kustuta(n.id)}>x</button> 
          </div> )}
      </div>
    </div>
  );
}

export default App;