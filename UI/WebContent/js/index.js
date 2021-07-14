
const fetchtable=()=>{
    fetch('http://localhost:8080/H2HBABBA3038/fetch')
    .then((serverPromise) => {
      //console.log(serverPromise)
      serverPromise.json()
        .then((data) => {
            window.d=data;
            console.log(window.d.length)
            console.log(data)
        changePage(data,1);
        })
        .catch((e) => console.log(e))
    })
    .catch((e) => console.log(e));
}
//load table
const showHeaders = (data) =>{
    // const tableArr = JSON.parse(data)
    let x = data[0]
    var col = [];
    Object.entries(x).forEach(entry => {
        const [key,value] =entry 
        col.push(key)
    })
    const tableMain = document.getElementById("GridHead")
    let tableRowEle = '<tr class="table-head">'
    tableRowEle += '<th>'+`<input type="checkbox" id="select_all_checkboxes" value="$(col[0])" />`+'<label class="sall_check" for="select_all_checkboxes"><img src="images/check_box_outline_blank-black-18dp.svg" /></label></th>'
    col.slice(1).forEach(tableRow => {
        tableRowEle += `<th class='$(String(tableRow).toLowerCase())'>`+String(tableRow).toUpperCase()+'</th>'
    })
    tableRowEle += '</tr>'
    tableMain.innerHTML = tableRowEle
}


// const showTableOnLoad = (check = true) => {
//     if(check){
//         showHeaders()
//     }
//     const tableArr =JSON.parse(data)
//         const tableMain = document.getElementById("GridBody");
//     tableArr.forEach((tableRow,index) => {
//         let tableRowEle = '<tr class="table-row">'
//         tableRowEle += '<td>'+`<input type="checkbox" id="check${index}" value="${tableRow.pkey}" class="tick" /><label class="sall_check" for="check${index}">`+'<img src="images/check_box_outline_blank-black-18dp.svg" /></label></th>'
//         Object.entries(tableRow).slice(1).forEach(entry => {
//             const [key,value] =entry 
//             tableRowEle += `<td class="${key}">`+value+'</td>'
//         })
//         tableRowEle += '</tr>'
//         tableMain.innerHTML += tableRowEle
//     })
// }
    
//////////////////////////////////////////////////////////////////////////////

 // Pagination and table upload   

    var current_page = 1;
    var records_per_page = 10;
    function prevPage()
    {
        if (current_page > 1) {
            current_page--;
            changePage(window.d,current_page);
        }
    }
    function nextPage()
    {
        if (current_page < numPages()) {
            current_page++;
            changePage(window.d,current_page);
        }
    } 
    //const tableArr =JSON.parse(data) //inside changePage and outside here (json data has to be passed)     
    function changePage(data,page)
    {
        var btn_next = document.getElementById("btn_next");
        var btn_prev = document.getElementById("btn_prev");
        var page_span = document.getElementById("page");
        const tableArr = (data)
        const tableMain = document.getElementById("GridBody");
        showHeaders(data)
       
        // Validate page
        if (page < 1) page = 1;
        if (page > numPages()) page = numPages();
        
        tableMain.innerHTML = "";

        for (var i = (page-1) * records_per_page; i < (page * records_per_page) && i < tableArr.length; i++) {
            let tableRowEle = '<tr class="table-row">'
            tableRowEle += '<td>'+`<input type="checkbox" id="check${i}" value="${tableArr[i].primkey}" class="tick" /><label class="sall_check" for="check${i}">`+'<img src="images/check_box_outline_blank-black-18dp.svg" /></label></th>'
            Object.entries(tableArr[i]).slice(1).forEach(entry => {
                const [key,value] =entry 
                tableRowEle += `<td class="${key}">`+value+'</td>'
            })
            tableRowEle += '</tr>'
            tableMain.innerHTML += tableRowEle
        }
        page_span.innerHTML = page + "/" + numPages();

        if (page == 1) {
            btn_prev.style.visibility = "hidden";
        } else {
            btn_prev.style.visibility = "visible";
        }

        if (page == numPages()) {
            btn_next.style.visibility = "hidden";
        } else {
            btn_next.style.visibility = "visible";
        }
    }

    function numPages()  
    {
        return Math.ceil(window.d.length / records_per_page);
    }
    
    // window.onload = function() {
    //     changePage(1)
    // };;   
//}

//////////////////////////////////////////////////////////////////////////////////////////////

//modal open and close

function openmodaladd(){
    add_modal.style.display = 'block';
    document.getElementById('cust_name').value = ''
    document.getElementById('cust_no').value = ''
    document.getElementById('in_no').value = ''
    document.getElementById('a_in_amt').value = ''
    document.getElementById('dd').value = ''
    document.getElementById('a_notes').value = ''
}
function closemodaladd(){
    add_modal.style.display = 'none';
    
}
function openmodaledit(){
    edit_modal.style.display = 'block';
    document.getElementById('e_in_amt').value = ''
    document.getElementById('e_notes').value = ''
}
function closemodaledit(){
    edit_modal.style.display = 'none';
}
function openmodaldel(){
    del_modal.style.display = 'block';
}
function closemodaldel(){
    del_modal.style.display = 'none';
}



//////////////////////////////////////////////////////////////////////////////////////////

// var cbs = document.querySelectorAll('input[type=checkbox]');
// for(var i = 0; i < cbs.length; i++) {    
//         console.log(cbs.values);
    
// }
// console.log(cbs)
// let checkBox = document.querySelectorAll(".tick");
// console.log(checkBox)
// let counttick = 0;
// function countCheck(){
//     for (var i=0; i<=checkBox.length; i++){
//         console.log(checkBox[i].defaultValue)
//         if (checkBox[i].checked === true){
//             counttick += 1;
//         }
//     }
//     return counttick;
// }

// let checkBoxCount = countCheck();
// console.log(checkBoxCount)
function CheckedValues(){
    var checkedValue=[] ; 
    var inputElements = document.getElementsByClassName('tick');
    for(var i=0; i<inputElements.length; ++i){
        if(inputElements[i].checked === true){
            checkedValue.push(inputElements[i].value);
        }
    }
    return checkedValue
}

function countCheck(){
    //normally edit and del button are disabled
    var counttick=0
    var cbox = document.getElementsByClassName('tick');
    for (var i=0; i<=cbox.length; i++){
        if (cbox[i].checked === true){
            counttick += 1;
        }
    }
    if(counttick===1){
        //disable add modal button and enable edit and delete
    }
    else if(counttick>1){
        //disable add and edit modal buttons and enable delete
    }


    
}


function add_data(){
    const cname= document.getElementById("cust_name").value    
    const cno= document.getElementById("cust_no").value
    const ino= document.getElementById("in_no").value
    const iamt= document.getElementById("a_in_amt").value
    const dd= document.getElementById("dd").value
    const notes= document.getElementById("a_notes").value
    console.log(cname)
    console.log(cno)
    console.log(ino)
    console.log(iamt)
    console.log(dd)
    console.log(notes)
    fetch(`http://localhost:8080/H2HBABBA3038/add?customer_number=${cno}&customer_name=${cname}&due_date=${dd}&invoice_id=${ino}&amount=${iamt}&notes=${notes}`,
    {
        method:'POST'
    })
    closemodaladd()    
}

function edit_data(){
    const iamt= document.getElementById("e_in_amt").value
    const notes= document.getElementById("e_notes").value
    console.log(iamt)
    console.log(notes)
    let x=CheckedValues()
    console.log(x)
    fetch(`http://localhost:8080/H2HBABBA3038/edit?amount=${iamt}&notes=${notes}&pkey=${x[0]}`,
    {
        method:'POST'
    })
    closemodaledit()    
}

function delete_data(){
    let x=CheckedValues()
    console.log(x)
    for(var i=0; i<x.length;i++){
        fetch(`http://localhost:8080/H2HBABBA3038/delete?pkey=${x[0]}`,
        {
            method:'POST'
        })
    }
    closemodaldel()
}
