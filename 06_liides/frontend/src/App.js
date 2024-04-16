
import './App.css';
import { useEffect, useRef, useState } from 'react';

function App() {
  const [mitu, setMitu] = useState(0);
  const [andmed, setAndmed] = useState([]);
  const nimiRef = useRef();
  const vanusRef = useRef();
  const suguRef = useRef();
  const [lisainfo, setLisainfo] = useState([]);
  const inNimiref = useRef();
  const elukohtRef = useRef();

  useEffect(()=>{
    fetch("http://localhost:8080/teine/andmed")
      .then(response => response.json())
      .then(json =>{
        setMitu(json.length);
        console.log(json);
        setAndmed(json);
      })
  }, [])

  useEffect(()=>{
    fetch("http://localhost:8080/veelandmeid")
      .then(response=>response.json())
      .then(json => {
        setLisainfo(json);
      })
  }, [])

  function lisa(){
    if(nimiRef.current.value.trim() === ""){
      return;
    }
    const info = {
      "nimi": nimiRef.current.value,
      "vanus": vanusRef.current.value,
      "sugu": suguRef.current.value
    }
    fetch("http://localhost:8080/teine/andmed",
    {
      "method": "POST",
      "body": JSON.stringify(info),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setMitu(json.length);
        console.log(json);
        setAndmed(json);
      })
  }

  function lisaKoht(){
    const lisatavKoht = {
      "info": {"nimi": inNimiref.current.value},
      "elukoht": elukohtRef.current.value
    }
    fetch("http://localhost:8080/veelandmeid", {
      "method": "POST",
      "body": JSON.stringify(lisatavKoht),
      "headers": {"Content-Type": "application/json"}})
      .then(response=>response.json())
      .then(json=>{
        setLisainfo(json);
      })
  }

  function kustuta(primaarvoti){
    fetch("http://localhost:8080/teine/andmed/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setMitu(json.length);
        setAndmed(json);
      })
  }

  function kustutaKoht(primaarvoti){
    fetch("http://localhost:8080/veelandmeid/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json=>{
        setLisainfo(json);
      })
  }




  return(
    <div className="App">
      Kokku on {mitu} inimest.
      <br/> <br/>

      <label>Nimi:</label> <br/>
      <input ref={nimiRef} type="text" /> <br/>

      <label>Vanus:</label> <br/>
      <input ref={vanusRef} type="text" /> <br/>

      <label>Sugu:</label> <br/>
      <input ref={suguRef} type="text" /> <br/>

      <button onClick = {()=>lisa()}>Sisesta</button> <br/>
      <br/>

      {andmed.map(a => <div key={a.nimi}> {a.nimi}   |   {a.vanus}   |   {a.sugu}   <button onClick={() => kustuta(a.nimi)}>x</button></div>)}
      <hr/>

      Elukohad:
      <br/> <br/>
      <label>Nimi:</label> <br/>
      <input ref={inNimiref} type="text" /> <br/>

      <label>Elukoht:</label> <br/>
      <input ref={elukohtRef} type="text" /> <br/>

      <button onClick = {()=>lisaKoht()}>Sisesta</button> <br/>

      {lisainfo.map(i => <div key={i.id}>  {i.info?.nimi}   |    {i.elukoht} <button onClick={() => kustutaKoht(i.id)}>x</button></div>)}




    </div>
  )
}

export default App;
