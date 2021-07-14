// const add_btn_click = () =>{
//     var modal = document.getElementsByClassName("add-bg-modal");
//     var closebtn = document.getElementsByClassName("close")[0];
//     var cancel = document.getElementsByClassName("btn_cancel")[0]
    
//         modal.style.display = "block";
//     closebtn.onclick = function() {
//         modal.style.display = "none";
//     }
//     cancel.onclick = function() {
//         modal.style.display = "none";
//     }
//     window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
//     }
// }




// const openModalButtons = document.querySelectorAll('[data-modal-target]')
// const closeModalButtons = document.querySelectorAll('[data-close]')
// const overlay = document.getElementById('overlay')

// openModalButtons.forEach(button =>{
//     button.addEventListener('click',()=>{
//         const modal = document.querySelector(button.dataset.modalTarget)
//         openModal(modal)
//     })
// })

// closeModalButtons.forEach(button =>{
//     button.addEventListener('click',()=>{
//         const modal = button.closest('.modal')
//         closeModal(modal)
//     })
// })

// overlay.addEventListener('click', ()=>{
//     const modals = document.querySelectorAll('.modal.active')
//     modals.forEach(modal =>{
//         closeModal(modal)
//     })
// })

// function openModal(modal){
//     if(modal == null)return
//     modal.classList.add('active')
//     overlay.classList.add('active')
// }

// function closeModal(modal){
//     if(modal == null)return
//     modal.classList.remove('active')
//     overlay.classList.remove('active')
// }

