//将返回的path进行拼接
export function filterMenu(menu){
    menu.map(el => {
            if(el.children && el.children.length){
                el.children.map(elc => {
                    elc.path = el.path + "/" + elc.path
                    return elc
                })
            }
            return el
        });
    return menu
}