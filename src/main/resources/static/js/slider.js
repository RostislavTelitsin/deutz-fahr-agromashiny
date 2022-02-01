
window.addEventListener('DOMContentLoaded', () => {
    'use strict';
    slider()
});

const slider = () => {
    const news = document.querySelectorAll('.news_full_description')
    news.forEach((item) => {
        let slideIndex = 1;
        item.addEventListener('click', function (e) {
            if (e.target.classList == "next" || e.target.classList == "prev") {
                const slides = [];
                let target_slider = null;
                if (!!e.path) {
                    target_slider = e.path[1];
                }
                else {
                    target_slider = e.target.parentNode;
                }

                target_slider.childNodes.forEach(element => {
                    if (element.classList == 'active' || element.classList == 'none') {
                        slides.push(element)

                    }
                })

                if (e.target.classList == "next") {
                    plusSlides(1);
                    slides.forEach((item) => {
                        item.style.display = "none";
                        // item.classList.add("animate__animated")
                    })
                    slides[slideIndex - 1].style.display = "block";
                    // slides[slideIndex - 1].classList.remove('animate__slideInRight');
                    // slides[slideIndex - 1].classList.add('animate__slideInLeft');

                }

                if (e.target.classList == "prev") {
                    plusSlides(-1);
                    slides.forEach((item) => {

                        item.style.display = "none";
                    })
                    slides[slideIndex - 1].style.display = "block";
                    // slides[slideIndex - 1].classList.remove('animate__slideInLeft');
                    // slides[slideIndex - 1].classList.add('animate__slideInRight');
                }

                function showSlides(n) {
                    if (n > slides.length) {
                        slideIndex = 1;
                    }
                    if (n < 1) {
                        slideIndex = slides.length;
                    }
                }

                function plusSlides(n) {
                    showSlides(slideIndex += n);
                }
            }
        })
    })
}
