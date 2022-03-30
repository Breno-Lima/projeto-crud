import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));
/*
const EditarAluno = (name,address) =>{
 
  const student={name,address}
  if(){

    console.log("ola");
  }else{
    console.log("droga");
  }

    
  
}
*/


export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])
    const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const student={name,address}
    console.log(student)
    fetch("http://localhost:8080/student/add",{ 
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    
    console.log("Novo aluno adicionado");
  })
}

//
const apagarAluno = (idAluno) =>{
    const student={name,address}
    console.log(student)
    fetch("http://localhost:8080/student/" + idAluno,{
      method:"DELETE",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("Aluno excluído com sucesso!");
  })
};





useEffect(()=>{
  fetch("http://localhost:8080/student/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])



  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Adicionar Aluno</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Nome do aluno" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Endereço do aluno" variant="outlined" fullWidth
      value={address}
      onChange={(e)=>setAddress(e.target.value)}
      />
      <Button  variant="contained" color="primary" onClick={handleClick}>Enviar</Button>
    </form>
   
    </Paper>
    <h1>Alunos</h1>

    <Paper elevation={3} style={paperStyle}>
      
      {students.map(student=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
         Id:{student.id}<br/> 
         Nome:{student.name}<br/>
         Endereço:{student.address}
        
         
          <th><Button variant="contained" color="secondary" onClick={() => apagarAluno(student.id)}>ExcLuir</Button></th>
          <th>⠀⠀⠀⠀</th>    

        
        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}