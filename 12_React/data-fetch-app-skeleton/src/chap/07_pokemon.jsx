/*
    종합: 포켓몬 도감
    지금까지 배운 것을 모두 사용한다.
    - state       : 현재 번호(id), 받아온 데이터(pokemon)
    - event       : 이전/다음 버튼
    - useEffect   : id가 바뀔 때마다 다시 요청   [id]
    - props       : 받아온 데이터를 PokemonCard에 전달
    - 반복 렌더링 : 타입 목록

    PokeAPI(https://pokeapi.co)는 회원가입이나 키 없이 쓸 수 있는 무료 API이다.
    https://pokeapi.co/api/v2/pokemon/1  ->  1번 포켓몬 정보

    버튼을 빠르게 누르면 이전 요청의 응답이 나중에 도착해 화면을 덮어쓸 수 있다.
    정리 함수에서 ignore = true로 바꿔 이전 요청의 결과는 무시한다.
*/
import { useEffect, useState } from 'react';

function PokemonCard({pokemon}) {
    return (
        <div>
            <h2>{pokemon.name}</h2>
            <img src={pokemon.sprites.front_default} alt={pokemon.name}/>
            <p>키: {pokemon.height / 10}m / 몸무게: {pokemon.weight / 10}kg</p>
            <p>
                {/* TODO 3: pokemon.types.map으로 타입 이름(t.type.name)을 <span>으로 출력하자. (key는 타입 이름) */}
                타입:
            </p>
        </div>
    );
}

export default function Pokemon() {

    const [id, setId] = useState(1);
    const [pokemon, setPokemon] = useState(null);

    /*
        TODO 1: id가 바뀔 때마다 포켓몬 정보를 요청해 setPokemon에 저장하자.   의존성 배열 [id]
                `https://pokeapi.co/api/v2/pokemon/${id}`

        TODO 4: let ignore = false; 를 만들고, ignore가 false일 때만 setPokemon 하자.
                정리 함수에서 ignore = true; 로 바꿔 이전 요청의 결과를 무시한다.
    */

    return (
        <>
            <h1>포켓몬 도감</h1>
            {/* TODO 2: 클릭하면 id를 1 감소 / 1 증가시키자. (prev 사용) */}
            <button disabled={id === 1}>이전</button>
            <span> No.{id} </span>
            <button>다음</button>

            {/* 아직 응답이 오지 않았거나, 이전 번호의 데이터라면 로딩 문구를 보여준다. */}
            {pokemon?.id === id ? <PokemonCard pokemon={pokemon}/> : <h3>불러오는 중...</h3>}
        </>
    );
}
