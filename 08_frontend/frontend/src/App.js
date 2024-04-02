//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';


function App() {
  const [kogus, setKogus] = useState(0); //useState -> kõik muutujad mis htmlis peab useStatei sisse panema
  const [toiduained, setToiduained] = useState([]);
  const nimiRef = useRef();
  const valkRef = useRef();
  const rasvRef = useRef();
  const sysivesikRef = useRef();
  
  //reacti hookid: use eesliidesega, neid peab importima. reacti erikood
  // springis annotatsioonid: @RestController, GetMapping. neid peab importima. springi erikood



  //uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/api/toiduained") // getmapping
      .then(response => response.json()) // koos metadataga(headerid, staatuskood, OK)
      .then(json => {
        setKogus(json.length); //oluline suur täht Kogus, sest nii saab ühenduse -- CONSTI PÄRAST
        setToiduained(json);
      }) // body
  }, []);

  //then.then on vajalik võtmise jaoks

  function kustuta(primaarvoti){
    fetch("http://localhost:8080/api/toiduained/" + primaarvoti, {"method": "DELETE"}) // deletemapping
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length); 
        setToiduained(json);
      })

  }

  function lisa(){
    //document.getElementByID("sad").value --> guugeldada 
    if(nimiRef.current.value.trim() === ""){
      return;
    }
    const toiduaine = {
      "nimetus": nimiRef.current.value,
      "valk": valkRef.current.value,
      "rasv": rasvRef.current.value,
      "sysivesik": sysivesikRef.current.value
    }
    fetch("http://localhost:8080/api/toiduained", 
    {
      "method": "POST", 
      "body": JSON.stringify(toiduaine), 
      "headers": {"Content-Type": "application/json"
    }}) 
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length); 
        setToiduained(json);
      })
  }

  return (
    <div className="App">
      Mul on {kogus} toiduainet
      <br/> <br/>

      <label>Toiduaine nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />

      <label>Toiduaine valk</label> <br/>
      <input ref={valkRef} type="text" /> <br />

      <label>Toiduaine rasv</label> <br/>
      <input ref={rasvRef} type="text" /> <br />

      <label>Toiduaine süsivesik</label> <br/>
      <input ref={sysivesikRef} type="text" /> <br />

      <button onClick = {()=>lisa()}>Sisesta</button> <br /> 
      <br/>
      {toiduained.map(t => <div>{t.nimetus} <button onClick={() => kustuta(t.nimetus)}>x</button></div>)} 
    </div>
  );  //.map on tsükkel ja teeb igaühe kohta sellise lõige nagu div vahel
}

export default App;
