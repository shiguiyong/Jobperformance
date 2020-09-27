const btn = document.querySelector('.btn');
const btn_txt = document.querySelector('.btn_txt');
const circles = document.querySelectorAll('.circle');
// console.log(btn,btn_txt,circles);

btn.addEventListener('click',()=>{
	btn_txt.innerHTML = "";
	circles.forEach((circle)=>{
		circle.classList.add('bring_to_top');
	});
});

const input_els = document.querySelectorAll('input');


input_els.forEach((input_el)=>{
	input_el.addEventListener('focus',(event)=>{
		const label_el = document.querySelector(`label[label_id="${event.target.attributes.input_id.value}"]`);
		label_el.style.transition = 'all 0.5s';
		label_el.style.zIndex = 1;
		label_el.style.transform = `translateY(-20px)`;
	});
	input_el.addEventListener('blur',(event)=>{
		const label_el = document.querySelector(`label[label_id="${event.target.attributes.input_id.value}"]`);
		label_el.style.transition = 'all 0s';
		label_el.style.zIndex = -1;
		label_el.style.transform = `translateY(0px)`;
	});
});